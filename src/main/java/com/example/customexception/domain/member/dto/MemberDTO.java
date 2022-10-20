package com.example.customexception.domain.member.dto;

import com.example.customexception.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static record MemberSignUpDto(@NotBlank(message = "아이디를 입력해주세요") @Size(min = 7, max = 25, message = "아이디는 7~25자 내외로 입력해주세요")
                                      String username,

                                  @NotBlank(message = "비밀번호를 입력해주세요")
                                  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                                          message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
                                  String password,

                                  @NotBlank(message = "닉네임을 입력해주세요.")
                                  @Size(min=2, message = "닉네임이 너무 짧습니다.")
                                  @NotBlank String nickName,


                                  @NotNull(message = "이메일을 입력해주세요")
                                  @Email
                                  String email) {

        public Member toEntity() {
            return Member.builder().username(username).password(password).nickname(nickName).email(email).build();
        }
    }

    public static record MemberWithdrawDto(@NotBlank(message = "비밀번호를 입력해주세요")
                                    String checkPassword) {
    }


    public static record UpdatePasswordDto(@NotBlank(message = "비밀번호를 입력해주세요")
                                           String checkPassword,

                                    @NotBlank(message = "비밀번호를 입력해주세요")
                                    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                                            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
                                    String toBePassword) {
    }

    @NoArgsConstructor
    public class MemberInfoDto {

        private String username;
        private String nickName;
        private String email;
        private String role;



        @Builder
        public MemberInfoDto(Member member) {
            this.username = member.getUsername();
            this.nickName = member.getNickname();
            this.email = member.getEmail();
            this.role = member.getRole().toString();
        }
    }

    public static record MemberUpdateDto(Optional<String> name, Optional<String> nickName,
                                  Optional<Integer> age) {

    }
}
