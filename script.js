import { data } from "./Data.js";
import { currentDate } from "./DateClass.js";
import getNote from "./newNote.js";

let num = 0;
let touchedId;
let body = document.getElementById("body");
let isdark = false;
let modeBtn = document.getElementById("mode-img");
let editor_container = document.getElementById("editor");
let notesContainer = document.getElementById("notes-wrapper");
let notes = document.querySelectorAll(".note-wrapper");
let feedBack = document.getElementById("feedback-res");
let addBtn = document.getElementById("add-note");
let closeBtn = document.getElementById("close-btn");
let navbar = document.getElementById("navbar");
let form_container = document.getElementById("form-container");
let closeEditorBtn = document.getElementById("close-btn-editor");
let cancelEditorBtn = document.getElementById("cancel-editor");

// Event listeners and API calls go here

Array.from(data).forEach((el) => {
  let newNote = document.createElement("div");
  newNote.innerHTML = getNote(el);
  notesContainer.appendChild(newNote);
  toggleNothing(++num);

  let deleteBtn = document.getElementById(`option-delete-${el.id}`);
  let editBtn = document.getElementById(`option-edit-${el.id}`);
  deleteBtn.addEventListener("click", () => {
    let consent = confirm(`⚠️ Do you want to delete this note ? 
    ${el.title}`);

    if (consent) {
      axios.delete(`http://localhost:8081/del/${el.id}`);
      newNote.remove();
      feedBack.style.visibility = "visible";

      setTimeout(() => {
        feedBack.style.visibility = "collapse";
      }, 1000);
    }
  });

  editBtn.addEventListener("click", () => {
    editor_container.style.display = "block";

    setTimeout(() => {
      editNote(el);
    }, 1000);
  });

  //Handle onclick on note card
let noteCard = document.getElementById(`${el.id}`);

noteCard.addEventListener("click",()=>{
  noteCard.style.scale = "1.05";
    let data = {
          title: el.title || "",
          dueAt: el.dueAt || "",
          desc: el.desc || ""
        };

    let query = new URLSearchParams(data).toString();    
  location.href = `/note.html?${query}`;
  

});
  

});
cancelEditorBtn.addEventListener("click", closeEdiorForm);

addBtn.addEventListener("click", () => {
  form_container.style.display = "block";
  console.log("showed");
  createNewNote();
});

closeBtn.addEventListener("click", closeForm);
closeEditorBtn.addEventListener("click", closeEdiorForm);

//🌓 Toggle Theme
let isLight = true;
modeBtn.addEventListener("click", (e) => {
  body.classList.toggle("dark");
  isLight = !isLight;
  let resource = isLight ? "./src/assets/moon2.svg" : "./src/assets/sun2.svg";
  modeBtn.setAttribute("src", resource);
});
//Edit note 📝

function editNote(el) {
  let save_edit = document.getElementById("save-edit");
  let editName = document.getElementById("title-ed");
  let editDate = document.getElementById("dueAt-ed");
  let editDesc = document.getElementById("desc-ed");

  editName.value = el.title || "";
  editDate.value = el.dueAt || "";
  editDesc.value = el.desc || "";
  console.log(editName);

  save_edit.addEventListener("click", (e) => {
    console.log(editDate);
    e.preventDefault();

    e.preventDefault();
    if (editDate.value >= currentDate) {
      if (editName.value || editDate.value || editDesc.value) {
        touchedId = el.id;
        let reqNote = {
          title: editName.value,
          dueAt: editDate.value,
          desc: editDesc.value,
        };
        axios
          .patch(`http://localhost:8081/update?id=${touchedId}`, reqNote)
          .then((res) => {
            console.log(res.data);

            feedBack.style.visibility = "visible";

            setTimeout(() => {
              location.reload();
            }, 2000);
            editor_container.style.display = "none";
            console.log(reqNote);
          });
        closeForm();
      }
    } else {
      alert("📅 Date should be of present of future.");
    }
  });
}

//Create a new note 📝
function createNewNote() {
  let saveNewNote = document.getElementById("note-form-btn");
  saveNewNote.addEventListener("click", () => {
    event.preventDefault();
    let registerForm = document.getElementById("form1");
    let formData = new FormData(registerForm);

    let title, desc, dueAt;
    title = formData.get("title");
    desc = formData.get("desc");
    dueAt = formData.get("dueAt");
    console.log(title, desc, dueAt);

    if (title.length != 0 && desc.length != 0 && dueAt.length != 0) {
      if (currentDate <= dueAt) {
        let data = {
          title: title,
          desc: desc,
          dueAt: dueAt,
        };

        axios
          .post(`http://localhost:8081/register`, data)
          .then((res) => {
            console.log(res.data);
            num++;
            if (num > 0) {
              nothingImg.style.display = "none";
            }
            console.log(num);
            form_container.style.display = "none";

            setTimeout(() => {
              location.reload();
            }, 1);
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        alert("You worngly chose a past date for your future plan.🧐");
      }
      closeForm();
    } else {
      alert("Make sure you fill all the fields.📄✅");
    }
  });
}
//🔒 Close the form
function closeForm() {
  form_container.style.display = "none";
}

function closeEdiorForm() {
  editor_container.style.display = "none";
}

//🗑️ Toggle nothing
function toggleNothing(num) {
  let nothingImg = document.getElementById("nothing_img");

  if (num > 0) {
    nothingImg.style.display = "none";
  } else {
    nothingImg.style.display = "block";
  }
}

//nav - scroll aniamtion
window.addEventListener("scroll", () => {
  let scrolly = window.scrollY;
  if (scrolly > 44) {
    navbar.style.textAlign = "start";
    navbar.style.backgroundColor = "var(--main-color)";
    navbar.style.boxShadow = "0px 0px 2px var(--main-color)";
  } else {
    navbar.style.textAlign = "center";
    navbar.style.backgroundColor = "transparent";
    navbar.style.boxShadow = "unset";
  }
});
