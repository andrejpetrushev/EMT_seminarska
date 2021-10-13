import React from "react";

const staff = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>
                            <th scope={"col"}>Position</th>
                            <th scope={"col"}>RatingDescription</th>
                            <th scope={"col"}>Number_suggestions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.staff.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.surname}</td>
                                    <td>{term.position}</td>
                                    <td>{term.ratingDescription}</td>
                                    <td>{term.number_suggestions}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default staff;
