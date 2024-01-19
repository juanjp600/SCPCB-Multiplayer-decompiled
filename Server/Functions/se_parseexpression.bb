Function se_parseexpression%(arg0.se_node, arg1.se_token)
    Local local0.se_node
    Local local1.se_node
    Local local3%
    Local local4.se_node
    Local local5.se_node
    If (arg1 <> Null) Then
        se_current_token = arg1
        se_order = $00
    EndIf
    local0 = arg0
    Repeat
        If (se_current_token\Field0 = $0D) Then
            If (arg0\Field0 <> Null) Then
                se_error_eol(se_current_token)
                Return $00
            Else
                Return $00
            EndIf
        EndIf
        local1 = se_definenode(se_current_token)
        If (local1 = Null) Then
            Return $00
        EndIf
        Select local1\Field1
            Case $01
                se_linknode(local1, local0, $01)
                se_current_token = (After se_current_token)
                se_parseexpression(local1, Null)
                If (se_error <> 0) Then
                    Return $00
                EndIf
                local0 = local1
            Case $03,$04
                local3 = $00
                Repeat
                    If (((local1\Field2 < local0\Field2) Or (local0 = arg0)) <> 0) Then
                        local3 = $01
                        Exit
                    ElseIf (local1\Field2 = local0\Field2) Then
                        If (local1\Field1 = $03) Then
                            se_error_unexpected(se_current_token)
                            Return $00
                        EndIf
                        local0 = local0\Field6
                        Exit
                    EndIf
                    local0 = local0\Field6
                Forever
                If (local3 <> 0) Then
                    local4 = local0\Field5[$01]
                    While (local4 <> Null)
                        If (local4\Field1 > $04) Then
                            Exit
                        EndIf
                        local5 = local4\Field7
                        se_linknode(local4, local1, $00)
                        local4 = local5
                    Wend
                EndIf
                se_linknode(local1, local0, $01)
                local0 = local1
            Case $05
                local0 = arg0
                se_linknode(local1, arg0, $01)
            Case $06
                If (arg0\Field0 = Null) Then
                    se_error(se_current_token, "mismatched brackets", $01)
                    Return $00
                ElseIf (arg0\Field0\Field0 <> (se_current_token\Field0 - $01)) Then
                    se_error(se_current_token, "mismatched brackets", $01)
                    Return $00
                EndIf
                se_linknode(local1, arg0, $01)
                Return $00
        End Select
        se_current_token = (After se_current_token)
    Forever
    Return $00
End Function
