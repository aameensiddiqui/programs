import { useState } from "react";
import { FaTrashAlt } from "react-icons/fa";

function Notes() {
  const notesList = [
    {
      id: 1,
      title: "delectus aut autem",
      completed: false,
    },
    {
      id: 2,
      title: "quis ut nam facilis et officia qui",
      completed: false,
    },
    {
      id: 3,
      title: "fugiat veniam minus",
      completed: false,
    },
    {
      id: 4,
      title: "et porro taempora",
      completed: true,
    },
    {
      id: 5,
      title: "laboriosam mollitia et enim quasi",
      completed: false,
    },
  ];

  const [items, setItems] = useState(notesList);

  const handleChecked = (id) => {
    console.log(id);
    const alteredList = items.map((item) =>
      item.id === id ? { ...item, completed: !item.completed } : item
    );
    setItems(alteredList);
    localStorage.setItem("todoss", JSON.stringify(alteredList));
  };

  const handleDelete = (id) => {
    console.log(id);
    const alteredList = items.filter((item) => item.id !== id);
    setItems(alteredList);
    localStorage.setItem("todoss", JSON.stringify(alteredList));
  };

  return (
    <div>
      {items.length ? (
        <ul>
          {items.map((item) => (
            <li key={item.id}>
              <input
                type="checkbox"
                checked={item.completed}
                onChange={() => handleChecked(item.id)}
              />
              <label
                onDoubleClick={() => handleChecked(item.id)}
                style={
                  item.completed ? { textDecoration: "line-through" } : null
                }
              >
                {item.title}
              </label>
              <FaTrashAlt role="button" onClick={() => handleDelete(item.id)} />
            </li>
          ))}
        </ul>
      ) : (
        <p>No to dos yet.</p>
      )}
    </div>
  );
}

export default Notes;
