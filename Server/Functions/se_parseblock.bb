Function se_parseblock%(arg0.se_block)
    Local local0.se_block
    Local local1.se_block
    local0 = (New se_block)
    local0\Field3 = se_current_chunk\Field1
    se_linkblock(local0, arg0)
    Select se_current_chunk\Field0
        Case $01
            Select se_current_chunk\Field1\Field1
                Case "const"
                    local0\Field0 = $02
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                Case "local","static","global","public"
                    local0\Field0 = $03
                    local0\Field1 = se_current_chunk\Field1\Field1
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                Case "def"
                    If (arg0 <> se_root_block) Then
                        se_error(se_current_chunk\Field1, "function can be defined only in main program", $01)
                        Return $00
                    EndIf
                    local0\Field0 = $04
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    se_parseblocks(local0)
                Case "if"
                    local0\Field0 = $05
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $01) Then
                        If (se_current_chunk\Field1\Field1 = "then") Then
                            se_current_chunk = (After se_current_chunk)
                        EndIf
                    EndIf
                    If (se_current_chunk\Field0 = $03) Then
                        se_current_chunk = (After se_current_chunk)
                        se_parseblocks(local0)
                    Else
                        se_parseblock(local0)
                    EndIf
                Case "else"
                    local0\Field0 = $06
                    If (((arg0\Field0 <> $05) And (arg0\Field0 <> $07)) <> 0) Then
                        se_error(se_current_chunk\Field1, "'else' belongs to nothing", $01)
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $01) Then
                        If (((se_current_chunk\Field1\Field1 = "if") And (arg0\Field0 = $05)) <> 0) Then
                            se_current_chunk = (After se_current_chunk)
                            If (se_checkchunk($02) <> 0) Then
                                Return $00
                            EndIf
                            local0\Field2 = se_current_chunk\Field2
                            se_current_chunk = (After se_current_chunk)
                        Else
                            se_error_unexpected(se_current_chunk\Field1)
                            Return $00
                        EndIf
                    ElseIf (se_current_chunk\Field0 <> $03) Then
                        se_error_unexpected(se_current_chunk\Field1)
                        Return $00
                    EndIf
                Case "select"
                    local0\Field0 = $07
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    se_parseblocks(local0)
                Case "case"
                    local0\Field0 = $08
                    If (arg0\Field0 <> $07) Then
                        se_error(se_current_chunk\Field1, "'case' belongs to nothing", $01)
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                Case "for"
                    local0\Field0 = $09
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $02) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        local1\Field1 = "init"
                        local1\Field2 = se_current_chunk\Field2
                        se_linkblock(local1, local0)
                        se_current_chunk = (After se_current_chunk)
                        If (((se_current_chunk\Field0 = $03) And (se_current_chunk\Field1\Field1 = ";")) = $00) Then
                            se_error_expecting(se_current_chunk\Field1, "';'")
                            Return $00
                        EndIf
                    ElseIf (((se_current_chunk\Field0 = $03) And (se_current_chunk\Field1\Field1 = ";")) <> 0) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        local1\Field1 = "init"
                        se_linkblock(local1, local0)
                    Else
                        se_error_expecting(se_current_chunk\Field1, "expression")
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $02) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        local1\Field2 = se_current_chunk\Field2
                        se_linkblock(local1, local0)
                        se_current_chunk = (After se_current_chunk)
                        If (((se_current_chunk\Field0 = $03) And (se_current_chunk\Field1\Field1 = ";")) = $00) Then
                            se_error_expecting(se_current_chunk\Field1, "';'")
                            Return $00
                        EndIf
                    ElseIf (((se_current_chunk\Field0 = $03) And (se_current_chunk\Field1\Field1 = ";")) <> 0) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        se_linkblock(local1, local0)
                    Else
                        se_error_expecting(se_current_chunk\Field1, "expression")
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $02) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        local1\Field2 = se_current_chunk\Field2
                        se_linkblock(local1, local0)
                        se_current_chunk = (After se_current_chunk)
                        If ((se_current_chunk\Field0 = $03) = $00) Then
                            se_error_expecting(se_current_chunk\Field1, "';'")
                            Return $00
                        EndIf
                    ElseIf (se_current_chunk\Field0 = $03) Then
                        local1 = (New se_block)
                        local1\Field0 = $01
                        se_linkblock(local1, local0)
                    Else
                        se_error_expecting(se_current_chunk\Field1, "expression")
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    se_parseblocks(local0)
                Case "while"
                    local0\Field0 = $0A
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($02) <> 0) Then
                        Return $00
                    EndIf
                    local0\Field2 = se_current_chunk\Field2
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    se_parseblocks(local0)
                Case "do"
                    local0\Field0 = $0B
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    se_parseblocks(local0)
                Case "repeat"
                    local0\Field0 = $0C
                    If (arg0\Field0 <> $0B) Then
                        se_error(se_current_chunk\Field1, "'repeat' without 'do'", $01)
                        Return $00
                    EndIf
                    se_current_chunk = (After se_current_chunk)
                    If (((se_current_chunk\Field0 = $01) And (se_current_chunk\Field1\Field1 = "if")) <> 0) Then
                        se_current_chunk = (After se_current_chunk)
                        If (se_current_chunk\Field0 = $02) Then
                            local0\Field2 = se_current_chunk\Field2
                            se_current_chunk = (After se_current_chunk)
                            If (se_checkchunk($03) <> 0) Then
                                Return $00
                            EndIf
                        EndIf
                    ElseIf (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                    Return $01
                Case "break"
                    local0\Field0 = $0D
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                Case "continue"
                    local0\Field0 = $0E
                    se_current_chunk = (After se_current_chunk)
                    If (se_checkchunk($03) <> 0) Then
                        Return $00
                    EndIf
                Case "return"
                    local0\Field0 = $0F
                    se_current_chunk = (After se_current_chunk)
                    If (se_current_chunk\Field0 = $02) Then
                        local0\Field2 = se_current_chunk\Field2
                        se_current_chunk = (After se_current_chunk)
                        If (se_checkchunk($03) <> 0) Then
                            Return $00
                        EndIf
                    ElseIf (se_current_chunk\Field0 <> $03) Then
                        se_error_unexpected(se_current_chunk\Field1)
                        Return $00
                    EndIf
            End Select
        Case $02
            local0\Field0 = $01
            local0\Field2 = se_current_chunk\Field2
            se_current_chunk = (After se_current_chunk)
            If (se_checkchunk($03) <> 0) Then
                Return $00
            EndIf
        Default
            se_error_unexpected(se_current_chunk\Field1)
    End Select
    Return $00
End Function
