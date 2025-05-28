📚 Kakao Book API 연동: 선택한 책 DB 저장 기능 구현 가이드
- 목표: Kakao Book API를 통해 조회한 도서 목록 중 사용자가 선택한 책 하나를 DB에 저장하는 기능을 구현한다.

⸻

✅ 1단계: 이슈 생성 (GitHub)
1.	GitHub 저장소 → Issues 탭 클릭
2.	New issue 버튼 클릭
3.	이슈 제목 작성: 선택한 도서 DB 저장 기능 구현

4.이슈 상세 내용 작성:

 	배경: 사용자가 검색 결과에서 원하는 도서를 선택하여 개인적으로 보관 가능하게 함
	목표: 선택한 도서 정보를 DB에 저장
	작업 내용:
		• Book 테이블 설계
		• Book 엔티티 클래스 생성
		• BookRepository 인터페이스 생성
		• 저장 API (/api/books/save) 개발
		• 저장 요청 데이터 정의 (SaveBookRequest)
		• 저장 로직 구현 및 응답 처리

5.	레이블/담당자/마일스톤 설정 (선택)
6.	Submit new issue 클릭 → 이슈 번호 확인 (예: #124)

⸻

✅ 2단계: 브랜치 생성 (IntelliJ)
1.	IntelliJ에서 프로젝트 오픈
2.	하단 Git 브랜치 패널 또는 VCS → Git → Branches 클릭
3.	브랜치 생성:
	- 이름 예시: feature/124-save-selected-book
	- 기반 브랜치: develop
4.	생성 후 해당 브랜치로 체크아웃

⸻

✅ 3단계: 기능 구현 (IntelliJ)

📌 1. Book 테이블 설계 및 엔티티 생성

    @Getter
    @Entity
    public class Book {
        @Id 
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String contents;
        private String authors;
        private String publisher;
        private String thumbnail;
    }

⸻

📌 2. Repository 생성

    @Repository
    public interface BookRepository extends JpaRepository<Book, Long> {
    // 커스텀 메서드 필요 시 추가
    }

⸻

📌 3. SaveBookRequest DTO 정의

    @Getter
    public class SaveBookRequest {
        private String title;
        private String contents;
        private List<String> authors;
        private String publisher;
        private String thumbnail;
    }

⸻

📌 4. BookSaveService 구현

    @Service
    public class BookSaveService {
        private final BookRepository bookRepository;

        public BookSaveService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
    
        public Book saveBook(SaveBookRequest request) {
            Book book = new Book();
            book.setTitle(request.getTitle());
            book.setContents(request.getContents());
            book.setAuthors(String.join(",", request.getAuthors()));
            book.setPublisher(request.getPublisher());
            book.setThumbnail(request.getThumbnail());
            return bookRepository.save(book);
        }
    }



⸻

📌 5. Controller API 엔드포인트 추가

    @RestController
    @RequestMapping("/api/books")
    public class BookController {
        private final BookSaveService bookSaveService;
    
        public BookController(BookSaveService bookSaveService) {
            this.bookSaveService = bookSaveService;
        }
    
        @PostMapping("/save")
        public ResponseEntity<Book> saveBook(@RequestBody SaveBookRequest saveBookRequest) {
            Book savedBook = bookSaveService.saveBook(saveBookRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }
    }

⸻

📌 6. 커밋

	git add .
	git commit -m "Feat: 선택한 도서 정보를 DB에 저장하는 기능 구현 (#124)"

⸻

✅ 4단계: Pull Request 생성 (GitHub)

1.	커밋 후 원격 브랜치 푸시
	- git push origin feature/124-save-selected-book
3.	GitHub → Pull requests → New pull request
4.	PR 설정:
	- base: develop
	- compare: feature/124-save-selected-book
5.	PR 제목
   	- Feat: 사용자가 선택한 도서 DB 저장 기능 구현
7.	PR 상세 설명:
	- 목적, 변경 사항 요약, 이슈 번호
8.	리뷰어 지정 및 Create pull request 클릭

⸻

✅ 5단계: 코드 리뷰 및 머지
1.	리뷰어 코드 리뷰 요청
2.	피드백 반영 후 재커밋 및 푸시
3.	테스트 및 리뷰 완료 시 Merge pull request
4.	머지 후 브랜치 삭제 (선택)

⸻
