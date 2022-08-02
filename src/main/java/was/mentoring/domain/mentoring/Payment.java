package was.mentoring.domain.mentoring;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import was.common.entity.BaseStatus;
import was.common.entity.BaseTimeEntity;
import was.common.entity.PaymentProcess;
import was.user.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentoringId")
    private Mentoring mentoring;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false)
    private Long price;

    private String depositor;

    private String bankCode;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private PaymentProcess paymentStatus;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;


}
