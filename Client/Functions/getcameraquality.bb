Function getcameraquality%(arg0%)
    Local local0%
    Select arg0
        Case $00
            local0 = $40
        Case $01
            local0 = $80
        Case $02
            local0 = $100
        Default
            Return $100
    End Select
    Return (Int min((Float local0), (Float graphicheight)))
    Return $00
End Function
