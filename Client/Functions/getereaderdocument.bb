Function getereaderdocument$(arg0%)
    Select arg0
        Case $00
            Return ""
        Case $01
            Return "doc_OBJC"
        Case $02
            Return "doc_SCL"
        Case $03
            Return "doc_O5(2)"
        Case $04
            Return "doc_MTF"
        Case $05
            Return "doc_MSP"
        Case $06
            Return "doc_NDP"
        Case $07
            Return "doc_005"
        Case $08
            Return "doc_008"
        Case $09
            Return "doc_012"
        Case $0A
            If (i_035\Field0 = $00) Then
                Return "doc_035_smile"
            Else
                Return "doc_035_sad"
            EndIf
        Case $0B
            Return "doc_049"
        Case $0C
            Return "doc_066"
        Case $0D
            Return "doc_IR_066"
        Case $0E
            Return "doc_079"
        Case $0F
            Return "doc_093_rm"
        Case $10
            Return "doc_096"
        Case $11
            Return "doc_106"
        Case $12
            Return "doc_IR_106"
        Case $13
            Return "doc_RP"
        Case $14
            Return "doc_173"
        Case $15
            Return "doc_205"
        Case $16
            Return "doc_372"
        Case $17
            Return "doc_409"
        Case $18
            Return "doc_427"
        Case $19
            Return "doc_500"
        Case $1A
            Return "doc_513"
        Case $1B
            Return "doc_682"
        Case $1C
            Return "doc_714"
        Case $1D
            Return "doc_860"
        Case $1E
            Return "doc_860_1"
        Case $1F
            Return "doc_895"
        Case $20
            Return "doc_939"
        Case $21
            Return "doc_966"
        Case $22
            Return "doc_970"
        Case $23
            Return "doc_999"
        Case $24
            Return "doc_1025"
        Case $25
            Return "doc_1048"
        Case $26
            Return "doc_IR_1048_a"
        Case $27
            Return "doc_1123"
        Case $28
            Return "doc_1162_ARC"
        Case $29
            Return "doc_1499"
    End Select
    Return ""
End Function
