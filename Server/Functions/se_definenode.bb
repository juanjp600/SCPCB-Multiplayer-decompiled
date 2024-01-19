Function se_definenode.se_node(arg0.se_token)
    Local local0%
    Local local1%
    Local local4.se_token
    Local local7.se_node
    se_order = (se_order + $01)
    Select arg0\Field0
        Case $01,$02,$03,$04
            local0 = $03
            local1 = $01
        Case $07
            Select arg0\Field1
                Case "args"
                    local0 = $03
                    local1 = $01
                Case "len","typeof"
                    local0 = $03
                    local1 = $02
                Case "++","--"
                    local0 = $03
                    local1 = $03
                Case "*"
                    local4 = (Before arg0)
                    If (local4 <> Null) Then
                        Select local4\Field0
                            Case $05,$0A,$07,$08,$09,$0C,$0D
                                local0 = $03
                                local1 = $03
                            Default
                                local0 = $04
                                local1 = $07
                        End Select
                    Else
                        local0 = $03
                        local1 = $03
                    EndIf
                Case "**"
                    local0 = $04
                    local1 = $04
                Case "~"
                    local0 = $03
                    local1 = $05
                Case "-"
                    local4 = (Before arg0)
                    If (local4 <> Null) Then
                        Select local4\Field0
                            Case $05,$0A,$07,$08,$09,$0C,$0D
                                local0 = $03
                                local1 = $06
                            Default
                                local0 = $04
                                local1 = $08
                        End Select
                    Else
                        local0 = $03
                        local1 = $06
                    EndIf
                Case "/","%"
                    local0 = $04
                    local1 = $07
                Case "+"
                    local0 = $04
                    local1 = $08
                Case "<<",">>"
                    local0 = $03
                    local1 = $09
                Case "&"
                    local0 = $04
                    local1 = $0A
                Case "^"
                    local0 = $04
                    local1 = $0B
                Case "|"
                    local0 = $04
                    local1 = $0C
                Case "<","<=",">",">=","==","!="
                    local0 = $04
                    local1 = $0D
                Case "not"
                    local0 = $03
                    local1 = $0E
                Case "and"
                    local0 = $04
                    local1 = $0F
                Case "or"
                    local0 = $04
                    local1 = $10
                Case "="
                    local0 = $03
                    local1 = $11
            End Select
        Case $08
            local0 = $05
        Case $05,$0A
            local0 = $01
            local1 = $01
        Case $06,$0B
            local0 = $06
        Default
            Return Null
    End Select
    local7 = (New se_node)
    local7\Field0 = arg0
    local7\Field1 = local0
    local7\Field2 = local1
    local7\Field3 = se_order
    Return local7
    Return Null
End Function
