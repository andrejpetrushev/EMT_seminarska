import React from 'react';

const roles = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>PersonId</th>
                            <th scope={"col"}>SpecialBonus</th>
                            <th scope={"col"}>Status</th>
                            <th scope={"col"}>RoleState</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.roles.map((term) => {
                            return (
                                <tr>
                                    <td>{term.personId}</td>
                                    <td>{term.specialBonus}</td>
                                    <td>{term.status}</td>
                                    <td>{term.roleState}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
};

export default roles;
