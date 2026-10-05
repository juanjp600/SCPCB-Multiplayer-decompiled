Function getscpdamage%(arg0%)
    Local local1%
    Select arg0
        Case model_939
            Return rand($1E, $28)
        Case model_860
            Return rand($28, $32)
        Case model_966
            Return rand($0A, $1E)
        Case local1
            Return rand($14, $1E)
        Case model_106
            Return rand($28, $32)
        Case model_035
            Return rand($0A, $0F)
        Default
            Return rand($14, $1E)
    End Select
    Return $00
End Function
