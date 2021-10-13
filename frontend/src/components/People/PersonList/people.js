import React from 'react';
import ReactPaginate from 'react-paginate'
import PersonTerm from '../PersonTerm/personTerm';
import {Link} from 'react-router-dom';

class People extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 2
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.people.length / this.state.size);
        const people = this.getPeoplePage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Person name</th>
                                <th scope={"col"}>Person surname</th>
                                <th scope={"col"}>Person age</th>
                                <th scope={"col"}>Person phone number</th>
                                <th scope={"col"}>Person address</th>
                                <th scope={"col"}>Rating</th>
                                <th scope={"col"}>Purchases</th>
                                <th scope={"col"}>Role</th>
                                <th scope={"col"}>Staff</th>
                            </tr>
                            </thead>
                            <tbody>
                            {people}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/people/add"}>Add new person</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    };

    getPeoplePage = (offset, nextPageOffset) => {
        return this.props.people.map((term, index) => {
            return (
                <PersonTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit}/>
            );
        }).filter((person, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}

export default People;
