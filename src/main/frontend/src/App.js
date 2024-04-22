import React, { useState } from "react";
import "./mycrosswordstyle.css";
import Crossword from "react-crossword";

export default function App() {
  const data = {
    id: "simple/1",
    number: 1,
    name: "Crossword 1",
    date: 1542326400000,
    entries: [
      {
        id: "1-down",
        number: 1,
        humanNumber: "1",
        clue: "Karib. Insel-gruppe",
        direction: "down",
        length: 7,
        group: ["1-down"],
        position: { x: 1, y: 0 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "2-across",
        number: 2,
        humanNumber: "2",
        clue: "folglich, mithin",
        direction: "across",
        length: 4,
        group: ["2-across"],
        position: { x: 1, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "3-across",
        number: 3,
        humanNumber: "3",
        clue: "Kieffertrip in d. alpinen Eisregion",
        direction: "across",
        length: 8,
        group: ["3-across"],
        position: { x: 1, y: 2 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "4-across",
        number: 4,
        humanNumber: "4",
        clue: "Schulfach (Kurzwort)",
        direction: "across",
        length: 5,
        group: ["4-across"],
        position: { x: 0, y: 3 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "5-across",
        number: 5,
        humanNumber: "5",
        clue: "Westgermane",
        direction: "across",
        length: 8,
        group: ["5-across"],
        position: { x: 1, y: 5 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "6-across",
        number: 6,
        humanNumber: "6",
        clue: "Elbe Zufluss",
        direction: "across",
        length: 4,
        group: ["6-across"],
        position: { x: 0, y: 6 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "7-across",
        number: 7,
        humanNumber: "7",
        clue: "jap.: auf Wiedersehen!",
        direction: "across",
        length: 8,
        group: ["7-across"],
        position: { x: 1, y: 8 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "8-across",
        number: 8,
        humanNumber: "8",
        clue: "Halbinsel Südwestgroßbritanniens",
        direction: "across",
        length: 5,
        group: ["8-across"],
        position: { x: 0, y: 9 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "9-down",
        number: 9,
        humanNumber: "9",
        clue: "Wassertiefenmesser",
        direction: "down",
        length: 3,
        group: ["9-down"],
        position: { x: 2, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "10-down",
        number: 10,
        humanNumber: "10",
        clue: "gesetlich",
        direction: "down",
        length: 5,
        group: ["10-down"],
        position: { x: 2, y: 5 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "11-down",
        number: 11,
        humanNumber: "11",
        clue: "von großem Gewicht",
        direction: "down",
        length: 6,
        group: ["11-down"],
        position: { x: 3, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "12-down",
        number: 12,
        humanNumber: "12",
        clue: "Norm/Kfz-Z. Jemen",
        direction: "down",
        length: 3,
        group: ["12-down"],
        position: { x: 3, y: 8 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "13-across",
        number: 13,
        humanNumber: "13",
        clue: "Tessiner Rotwein",
        direction: "across",
        length: 6,
        group: ["13-across"],
        position: { x: 3, y: 10 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "14-down",
        number: 14,
        humanNumber: "14",
        clue: "lichte Glut",
        direction: "down",
        length: 4,
        group: ["14-down"],
        position: { x: 4, y: 0 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "15-down",
        number: 15,
        humanNumber: "15",
        clue: "edle Blume",
        direction: "down",
        length: 4,
        group: ["15-down"],
        position: { x: 4, y: 7 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "16-across",
        number: 16,
        humanNumber: "16",
        clue: "ängstlich, mutlos",
        direction: "across",
        length: 4,
        group: ["16-across"],
        position: { x: 5, y: 4 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "17-across",
        number: 17,
        humanNumber: "17",
        clue: "Dateiformatendung",
        direction: "across",
        length: 3,
        group: ["17-across"],
        position: { x: 6, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "18-down",
        number: 18,
        humanNumber: "18",
        clue: "Republik und Volk in Europa",
        direction: "down",
        length: 5,
        group: ["18-down"],
        position: { x: 6, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "19-down",
        number: 19,
        humanNumber: "19",
        clue: "abwertend: Pferd",
        direction: "down",
        length: 4,
        group: ["19-down"],
        position: { x: 6, y: 7 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "20-down",
        number: 20,
        humanNumber: "20",
        clue: "persönl. Fürwort. 2. Person Singular",
        direction: "down",
        length: 2,
        group: ["20-down"],
        position: { x: 7, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "21-down",
        number: 21,
        humanNumber: "21",
        clue: "Bitte um Antwort",
        direction: "down",
        length: 5,
        group: ["21-down"],
        position: { x: 8, y: 1 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "22-down",
        number: 22,
        humanNumber: "22",
        clue: "Bürde",
        direction: "down",
        length: 4,
        group: ["22-down"],
        position: { x: 8, y: 7 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "23-down",
        number: 23,
        humanNumber: "23",
        clue: "Nähmittel",
        direction: "down",
        length: 5,
        group: ["23-down"],
        position: { x: 5, y: 4 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "24-across",
        number: 24,
        humanNumber: "24",
        clue: "3. und 4. Fall von wir",
        direction: "across",
        length: 3,
        group: ["24-across"],
        position: { x: 6, y: 9 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "25-down",
        number: 25,
        humanNumber: "25",
        clue: "Unterwelt, Hölle",
        direction: "down",
        length: 7,
        group: ["25-down"],
        position: { x: 7, y: 4 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "26-down",
        number: 26,
        humanNumber: "26",
        clue: "Erfinder des Saxofons 1894",
        direction: "down",
        length: 3,
        group: ["26-down"],
        position: { x: 1, y: 8 },
        separatorLocations: {},
        solution: "",
      },
      {
        id: "Lösung",
        number: 27,
        humanNumber: "27",
        clue: "Lösung",
        direction: "across",
        length: 6,
        group: ["Lösung"],
        position: { x: 3, y: 11 },
        separatorLocations: {},
        solution: "",
      },
    ],
    solutionAvailable: true,
    dimensions: {
      cols: 13,
      rows: 13,
    },
    crosswordType: "quick",
  };

  const [solution, setSolution] = useState([]);
  const [selectedOption, setSelectedOption] = useState("");

  function generateRandomString(length) {
    const charset =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    let result = "";
    for (let i = 0; i < length; i++) {
      const randomIndex = Math.floor(Math.random() * charset.length);
      result += charset[randomIndex];
    }
    return result;
  }

  async function handleGetSolution() {
    const selected_data = window.location.hash.substring(1);
    if (selected_data) {
      const selected_word = data.entries.filter((d) => d.id === selected_data);
      const solutionFromAPI = await (await fetch("/api/search?query=" + encodeURI(selected_word[0].clue) + "&characters=" + selected_word[0].length)).json()
      setSolution(solutionFromAPI.map(x => x.answer));
      console.log(solution);
    }
  }

  function handleSetSolution() {
    const selected_data = window.location.hash.substring(1);
    if (selected_data) {
      const selected_word = data.entries.filter((d) => d.id === selected_data);
      selected_word[0].solution = selectedOption;
    }
  }
  return (
    <div className="App">
      <div style={{ marginLeft: "10%" }}>
        <button onClick={handleGetSolution}>get solution</button>
        <br />
        <label>Select an option:</label>
        <select onChange={(e) => setSelectedOption(e.target.value)}>
          {solution.map((v) => (
            <option value={v}>{v}</option>
          ))}
        </select>
        <br />
        <button onClick={handleSetSolution}>set solution</button>
      </div>
      <Crossword data={data} />
    </div>
  );
}
