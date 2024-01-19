Function se_parselines%(arg0$)
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8.se_pptoken
    Local local10$
    Local local11$
    Local local12$
    Local local13.defines
    Local local14.se_line
    local0 = readfile(arg0)
    If (local0 = $00) Then
        se_warn(Null, ((("unable to open file " + chr($22)) + arg0) + chr($22)))
        Return $00
    EndIf
    seekfile(local0, $00)
    While (eof(local0) = $00)
        local1 = trim(readline(local0))
        local2 = len(local1)
        local3 = $01
        local4 = $00
        local5 = $00
        local6 = $00
        local7 = (local7 + $01)
        If (left(local1, $01) = "#") Then
            Delete Each se_pptoken
            se_parsedirective(right(local1, (local2 - $01)))
            local8 = (First se_pptoken)
            Select local8\Field0
                Case "playerscript","PLAYERSCRIPT"
                    mainfunctionerrorblock = $01
                Case "define"
                    local10 = ""
                    local10 = deletestringfromstring(local1, "#define ")
                    local10 = replace(local10, " = ", "=")
                    local10 = replace(local10, " =", "=")
                    local10 = replace(local10, "= ", "=")
                    If (instr(local10, "=", $01) <> 0) Then
                        local11 = right(local10, (len(local10) - instrlatest(local10, "=", $01)))
                        local12 = left(local10, (instrlatest(local10, "=", $01) - $01))
                        For local13 = Each defines
                            local11 = replace(local11, local13\Field1, local13\Field0)
                        Next
                        declaredefine(local12, local11)
                    ElseIf (instr(local10, " ", $01) <> 0) Then
                        local11 = right(local10, (len(local10) - instrlatest(local10, " ", $01)))
                        local12 = left(local10, (instrlatest(local10, " ", $01) - $01))
                        For local13 = Each defines
                            local11 = replace(local11, local13\Field1, local13\Field0)
                        Next
                        declaredefine(local12, local11)
                    Else
                        declaredefine(local10, "")
                    EndIf
                Case "define_ex"
                    local10 = ""
                    local10 = deletestringfromstring(local1, "#define_ex ")
                    local10 = replace(local10, " = ", "=")
                    local10 = replace(local10, " =", "=")
                    local10 = replace(local10, "= ", "=")
                    If (instr(local10, "=", $01) <> 0) Then
                        local11 = right(local10, (len(local10) - instr(local10, "=", $01)))
                        local12 = left(local10, (instr(local10, "=", $01) - $01))
                        For local13 = Each defines
                            local11 = replace(local11, local13\Field1, local13\Field0)
                        Next
                        declaredefine(local12, local11)
                    ElseIf (instr(local10, " ", $01) <> 0) Then
                        local11 = right(local10, (len(local10) - instr(local10, " ", $01)))
                        local12 = left(local10, (instr(local10, " ", $01) - $01))
                        For local13 = Each defines
                            local11 = replace(local11, local13\Field1, local13\Field0)
                        Next
                        declaredefine(local12, local11)
                    Else
                        declaredefine(local10, "")
                    EndIf
                Case "include"
                    local8 = (After local8)
                    se_pp_include(local8\Field0, arg0)
                    If (se_error <> 0) Then
                        Return $00
                    EndIf
                Default
                    se_warn(Null, (("undefined preprocessor directive execution (" + local8\Field0) + ")"))
            End Select
            Delete Each se_pptoken
            If (se_error <> 0) Then
                Return $00
            EndIf
            local2 = $00
        Else
            For local13 = Each defines
                local1 = replace(local1, local13\Field1, local13\Field0)
            Next
        EndIf
        While (local3 < local2)
            If (mid(local1, local3, $02) = "//") Then
                local1 = left(local1, (local3 - $01))
                local2 = len(local1)
                Exit
            ElseIf (mid(local1, local3, $02) = "/*") Then
                local1 = (left(local1, (local3 - $01)) + right(local1, ((local2 - local3) - $01)))
                local2 = len(local1)
                local5 = local3
                local4 = (local4 + $01)
                local3 = (local3 + $02)
            ElseIf (mid(local1, local3, $02) = "*/") Then
                local4 = (local4 - $01)
                If (local4 = $00) Then
                    If (local5 = $00) Then
                        local1 = right(local1, ((local2 - local3) - $01))
                        local2 = len(local1)
                        local3 = $01
                    Else
                        local1 = (left(local1, (local5 - $01)) + right(local1, ((local2 - local3) - $01)))
                        local2 = len(local1)
                        local3 = (local5 + $01)
                    EndIf
                Else
                    local3 = (local3 + $02)
                EndIf
            ElseIf (mid(local1, local3, $01) = chr($22)) Then
                local3 = instr(local1, chr($22), (local3 + $01))
                If (local3 = $00) Then
                    se_seterror((((("Terror at line " + (Str local7)) + ": expecting '") + chr($22)) + "'"), $01)
                    Return $00
                EndIf
                local3 = (local3 + $01)
            Else
                local3 = (local3 + $01)
            EndIf
        Wend
        If (local4 = $00) Then
            local1 = trim(local1)
            If (local2 <> 0) Then
                local2 = len(local1)
            EndIf
            If (local2 > $00) Then
                local14 = (New se_line)
                local14\Field0 = local1
                local14\Field1 = local7
                local14\Field2 = local2
            EndIf
        EndIf
        debuglog(local1)
    Wend
    If (local4 <> 0) Then
        se_warn(Null, "expecting */")
    EndIf
    closefile(local0)
    Return $00
End Function
