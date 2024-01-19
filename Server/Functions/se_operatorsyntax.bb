Function se_operatorsyntax%(arg0.se_node)
    Local local0%
    Local local1.se_token
    Local local2.se_node
    Local local3.se_node
    local0 = $01
    Repeat
        local1 = arg0\Field0
        Select local1\Field1
            Case "="
                local2 = arg0\Field4[$00]
                local3 = arg0\Field4[$01]
                If (local2 <> Null) Then
                    If (local2\Field0\Field0 = $04) Then
                        If (se_checkconstant(local2\Field0\Field1) <> 0) Then
                            se_error(local1, "cannot assign value to constant", $01)
                            Return $00
                        ElseIf (se_checkfunction(local2\Field0\Field1) <> 0) Then
                            se_error(local1, "cannot assign value to function", $01)
                            Return $00
                        EndIf
                    Else
                        se_error_unexpected(local1)
                        Return $00
                    EndIf
                Else
                    se_error_unexpected(local1)
                    Return $00
                EndIf
                If (local3 <> Null) Then
                    se_nodesyntax(local3)
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                Else
                    se_error(local1, "expecting expression", $01)
                    Return $00
                EndIf
            Case "**","/","%","+","<<",">>","&","^","|","<","<=",">",">=","==","!=","and","or"
                local2 = arg0\Field4[$00]
                local3 = arg0\Field4[$01]
                If (local0 <> 0) Then
                    If (local2 = Null) Then
                        se_error_unexpected(local1)
                        Return $00
                    EndIf
                    local0 = $00
                EndIf
                If (local2 <> Null) Then
                    se_nodesyntax(local2)
                EndIf
                If (se_error <> 0) Then
                    Return $00
                EndIf
                If (local3 = Null) Then
                    se_error(local1, "expecting expression", $01)
                    Return $00
                EndIf
                se_nodesyntax(local3)
                If (se_error <> 0) Then
                    Return $00
                EndIf
            Case "-"
                If (arg0\Field1 = $04) Then
                    local2 = arg0\Field4[$00]
                    local3 = arg0\Field4[$01]
                    If (local0 <> 0) Then
                        If (local2 = Null) Then
                            se_error_unexpected(local1)
                            Return $00
                        EndIf
                        local0 = $00
                    EndIf
                    If (local2 <> Null) Then
                        se_nodesyntax(local2)
                    EndIf
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                    If (local3 = Null) Then
                        se_error(local1, "expecting expression", $01)
                        Return $00
                    EndIf
                    se_nodesyntax(local3)
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                Else
                    local3 = arg0\Field4[$01]
                    If (local3 = Null) Then
                        se_error(local1, "expecting expression", $01)
                        Return $00
                    EndIf
                    se_nodesyntax(local3)
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                EndIf
            Case "*"
                local2 = arg0\Field4[$00]
                local3 = arg0\Field4[$01]
                If (arg0\Field2 = $07) Then
                    If (local0 <> 0) Then
                        If (local2 = Null) Then
                            se_error_unexpected(local1)
                            Return $00
                        EndIf
                        local0 = $00
                    EndIf
                    If (local2 <> Null) Then
                        se_nodesyntax(local2)
                    EndIf
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                    If (local3 = Null) Then
                        se_error(local1, "expecting expression", $01)
                        Return $00
                    EndIf
                    se_nodesyntax(local3)
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                Else
                    If (local3 = Null) Then
                        se_error(local1, "expecting identifier", $01)
                        Return $00
                    EndIf
                    If (local3\Field0\Field0 <> $04) Then
                        se_error_expecting(local3\Field0, "variable identifier")
                        Return $00
                    EndIf
                    If (local3\Field4[$01] <> Null) Then
                        se_error_unexpected(local3\Field4[$01]\Field0)
                        Return $00
                    EndIf
                EndIf
            Case "++","--"
                local2 = arg0\Field4[$00]
                local3 = arg0\Field4[$01]
                If (((local2 = Null) And (local3 = Null)) <> 0) Then
                    se_error(local1, "expecting variable identifier", $01)
                    Return $00
                EndIf
                If (((local2 <> Null) And (local3 <> Null)) <> 0) Then
                    se_error(local1, ("undefined argument for " + local1\Field4), $01)
                    Return $00
                EndIf
                If (local2 <> Null) Then
                    If (local2\Field0\Field0 = $04) Then
                        If (local2\Field4[$01] <> Null) Then
                            If (local2\Field4[$01]\Field0\Field0 <> $0A) Then
                                se_error_unexpected(local2\Field4[$01]\Field0)
                                Return $00
                            EndIf
                        EndIf
                        If (se_checkconstant(local2\Field0\Field1) <> 0) Then
                            se_error(local2\Field0, (("operator " + local1\Field4) + " cannot be applied to constants"), $01)
                            Return $00
                        ElseIf (se_checkfunction(local2\Field0\Field1) <> 0) Then
                            se_error(local2\Field0, (("operator " + local1\Field4) + " cannot be applied to functions"), $01)
                            Return $00
                        EndIf
                    Else
                        se_error_expecting(local2\Field0, "variable identifier")
                        Return $00
                    EndIf
                ElseIf (local3\Field0\Field0 = $04) Then
                    If (local3\Field4[$01] <> Null) Then
                        If (local3\Field4[$01]\Field0\Field0 <> $0A) Then
                            se_error_unexpected(local3\Field4[$01]\Field0)
                            Return $00
                        EndIf
                    EndIf
                    If (se_checkconstant(local3\Field0\Field1) <> 0) Then
                        se_error(local3\Field0, (("operator " + local1\Field4) + " cannot be applied to constants"), $01)
                        Return $00
                    ElseIf (se_checkfunction(local3\Field0\Field1) <> 0) Then
                        se_error(local3\Field0, (("operator " + local1\Field4) + " cannot be applied to functions"), $01)
                        Return $00
                    EndIf
                Else
                    se_error_expecting(local3\Field0, "variable identifier")
                    Return $00
                EndIf
            Case "typeof","~","not","len"
                local2 = arg0\Field4[$00]
                local3 = arg0\Field4[$01]
                If (local2 <> Null) Then
                    se_error_unexpected(local2\Field0)
                    Return $00
                EndIf
                If (local3 = Null) Then
                    se_error(local1, "expecting expression", $01)
                    Return $00
                EndIf
                se_nodesyntax(local3)
                If (se_error <> 0) Then
                    Return $00
                EndIf
        End Select
        If (arg0\Field8 = Null) Then
            Exit
        ElseIf (arg0\Field1 = $03) Then
            If (((arg0\Field8\Field1 = $06) Or (arg0\Field8\Field1 = $05)) <> 0) Then
                Exit
            Else
                se_error_unexpected(arg0\Field0)
                Return $00
            EndIf
        ElseIf (((arg0\Field8\Field1 = $06) Or (arg0\Field8\Field1 = $05)) <> 0) Then
            Exit
        EndIf
        If (arg0\Field1 = $03) Then
            Exit
        ElseIf (arg0\Field1 = $04) Then
            arg0 = arg0\Field8
        EndIf
        If (arg0 = Null) Then
            Exit
        EndIf
    Forever
    Return $00
End Function
