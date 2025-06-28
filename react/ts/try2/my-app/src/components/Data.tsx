import { useEffect, useState } from "react";

export const FetchData = () => {
  const [data, setData] = useState<string[]>([]); // Array of strings

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((posts) => setData(posts.map((post: any) => post.title)));
  }, []);

  return (
    <ul>
      {data.map((item) => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  );
};
