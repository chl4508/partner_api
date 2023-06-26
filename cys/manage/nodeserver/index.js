//express 모듈 불러오기
const express = require("express");
//express 사용
const app = express();

//Express 4.16.0버전 부터 body-parser의 일부 기능이 익스프레스에 내장 body-parser 연결
app.use(express.json());
app.use(express.urlencoded({ extended: true}));


//임시 데이터
const tests = [
 { id: 1, name: "test1" },
 { id: 2, name: "test2" },
 { id: 3, name: "test3" }
];


/**
 * @path {GET} http://localhost:3000/
 * @description 요청 데이터 값이 없고 반환 값이 있는 GET Method
 */
app.get("/", (req, res) => {
    //Hello World 데이터 반환
    res.send("Hello World");
});

/**
 * @path {GET} http://localhost:3000/api/tests
 * @description 요청 데이터 값이 없고 반환 값이 있는 GET Method
 */
app.get("/api/tests", (req, res) => {

    //유저 정보 반환
    res.json({ok: true, tests: tests});
})

/**
 * @path {GET} http://localhost:3000/api/tests/test?test_id=1
 * @description Query Params 요청 데이터 값이 있고 반환 값이 있는 GET Method
 *
 *  Query Params 방식
 *  user 뒤에 user_id변수를 통해 값을 찾아 올수 있다.
 *  &를 통해 두번째 변수를 받아서 사용할 수 있다.(/test?test_id=1&name="test1")
 *
 */
app.get("/api/tests/test", (req, res) => {

    const test_id = req.query.test_id

    //filter라는 함수는 자바스크립트에서 배열 함수이다. 필터링을 할때 많이 사용된다 필터링한 데이터를 새로운 배열로 반환한다.
    const test = tests.filter(data => data.id == test_id);

    res.json({ok: false, test: test})
})

/**
 * @path {GET} http://localhost:3000/api/tests/:test_id
 * @description Path Variables 요청 데이터 값이 있고 반환 값이 있는 GET Method
 *
 *  Path Variables 방식
 *
 *  ex) 아래 GET 주소 에서 :test_id 는 서버에서 설정한 주소 키 값이다.
 *      값을 찾을 때는 req.params.test_id 로 값을 찾는다.
 *
 *  *주의 사항*
 *  :test_id 이 부분은 변수이기 때문에
 *  경로가 /tests/1 이거나 /tests/2 이거 일때 둘다 라우터를 거치게 된다.
 *  그렇기 때문에 다른 라우터 보다 아래 있어야 한다.
 */
app.get("/api/tests/:test_id", (req, res) => {

    const test_id = req.params.test_id

    //filter라는 함수는 자바스크립트에서 배열 함수이다. 필터링을 할때 많이 사용된다 필터링한 데이터를 새로운 배열로 반환한다.
    const test = tests.filter(data => data.id == test_id);

    res.json({ok: true, test: test})
})

/**
 * @path {POST} http://localhost:3000/api/tests
 * @description POST Method
 *
 *  POST 데이터를 생성할 때 사용된다.
 *  req.body에 데이터를 담아서 보통 보낸다.
 */
app.post("/api/tests", (req, res) => {

    // 구조분해를 통해 id 와 name을 추출
    const { id, name } = req.body

    //concat 함수는 자바스크립트에서 배열 함수이다. 새로운 데이터를 추가하면 새로운 배열로 반환한다.
    const test = tests.concat({id, name});

    res.json({ok: true, tests: test})
})

/**
 * @path {PUT} http://localhost:3000/api/tests
 * @description 전체 데이터를 수정할 때 사용되는 Method
 */
app.put("/api/tests", (req, res) => {

    // 구조분해를 통해 id 와 name을 추출
    const { id, name } = req.body

    //map 함수는 자바스크립트에서 배열 함수이다. 요소를 일괄적으로 변경할 때 사용됩니다.
    const test = tests.map(data => {

        if(data.id == id) data.name = name

        return {
            id: data.id,
            name: data.name
        }
    })

    res.json({ok: true, tests: test})
})

/**
 * @path {PATCH} http://localhost:3000/api/tests/:test_id
 * @description 단일 데이터를 수정할 때 사용되는 Method
 */
app.patch("/api/tests/:test_id", (req, res) => {

    const { test_id} = req.params
    const { name } = req.body

    //map 함수는 자바스크립트에서 배열 함수이다. 요소를 일괄적으로 변경할 때 사용됩니다.
    const test = tests.map(data => {

        if(data.id == user_id) data.name = name

        return {
            id: data.id,
            name: data.name
        }
    })

    res.json({ok: true, tests: test})
})

/**
 * @path {DELETE} http://localhost:3000/api/tests/:test_id
 * @description 데이터 삭제
 *
 */
app.delete("/api/tests/:test_id", (req, res) => {

    const test_id = req.query.test_id

    //filter라는 함수는 자바스크립트에서 배열 함수이다. 필터링을 할때 많이 사용된다 필터링한 데이터를 새로운 배열로 반환한다.
    const test = tests.filter(data => data.id != test_id );

    res.json({ok: true, tests: test})
})

// http listen port 생성 서버 실행
app.listen(3000, () => console.log("test node express server)"));