package com.example.regularshowconstraintlayout.model

enum class Category(val group: String, val detail: CategoryDetail) {
    President("President", CategoryDetail(listOf
        (MemberDetail("Mike Lindsay", "My name is Mike Lindsay and I am senior majoring in Computer Engineering, I am a current intern at Apple hooping to get a full time offer!")))
    ),
    VicePresident("Vice President", CategoryDetail(listOf
        (MemberDetail("Darrell Otoo", "My name is darrell Otoo and I am the vice president")))),
    Secretary("Secretary", CategoryDetail(listOf
        (MemberDetail("Ziad kashef", "My name is ziad and I am your secretary for the second year in a row"))))
    ,Treasurer("Treasurer",CategoryDetail(listOf
        (MemberDetail("Tariq Gafar","My name is Tariq Gafar, and I am the new Treasurer.I a rising junior majoring in computer science and this past summer I interned at MatchGroup" +
            "as an android engineer"))))
    ,ProgramsChair("Programs Chair", CategoryDetail(listOf
        (MemberDetail("idk","idk")))),
    Senator("Senator", CategoryDetail(listOf
        (MemberDetail("idk","idk")))),
    Historian("Historian", CategoryDetail(listOf
        (MemberDetail("idk","idk")))),
    TorchChair("Torch Chair", CategoryDetail(listOf
        (MemberDetail("idk","idk")))),
    telecommunicatons("Telecommunications", CategoryDetail(listOf
        (MemberDetail("idk","idk")))),
    proffesionalDeveloment("Professional Development", CategoryDetail(listOf(
        MemberDetail("CJ", "idk")))),
    AcademicExcellence("Academic Excellence Chair", CategoryDetail(listOf(
        MemberDetail("Vanessa", "idk")))),
    MembershipChair(" Membership Chair", CategoryDetail(listOf(
        MemberDetail("Lauren", "idk")))),
    ConventioPlanning("Convention Planning", CategoryDetail(listOf(
        MemberDetail("Noah Mccain", "idk")))),





    /*
    {
        "group": "President",
        "detail": {
            "members": [
                {
                    "quote": "Name",
                    "name": "Mike Lindsay"
                }
            ]
        }

    }
     */

}