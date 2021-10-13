import React from 'react';
import {Link} from 'react-router-dom';

const personTerm = (props) => {
    return (
        <tr>
            <td>{props.term.personName}</td>
            <td>{props.term.personSurname}</td>
            <td>{props.term.personAge}</td>
            <td>{props.term.personPhoneNumber}</td>
            <td>{props.term.personAddress}</td>
            <td>{props.term.rating}</td>
            <td>{props.term.purchases}</td>
            <td>{props.term.role.roleState}</td>
            <td>{props.term.staff.name}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/people/edit/${props.term.id}`}>
                    Edit
                </Link>
            </td>
        </tr>
    )
};

export default personTerm;
