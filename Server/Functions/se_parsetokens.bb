Function se_parsetokens%()
    Local local0.se_line
    Local local1%
    Local local2$
    Local local3%
    Local local4.se_token
    Local local5$
    Local local6%
    Local local7%
    Local local8$
    Local local9%
    For local0 = Each se_line
        local1 = $00
        local2 = local0\Field0
        local3 = local0\Field2
        Repeat
            local4 = Null
            local1 = (local1 + $01)
            If (local1 > local3) Then
                se_createtoken($0D, "", local0, local1, "end of line")
                Exit
            EndIf
            local5 = mid(local2, local1, $01)
            While (((asc(local5) <= $20) Or (asc(local5) = $7F)) <> 0)
                local1 = (local1 + $01)
                local5 = mid(local2, local1, $01)
            Wend
            If (local5 = "(") Then
                se_createtoken($05, "(", local0, local1, "'('")
            ElseIf (local5 = ")") Then
                se_createtoken($06, ")", local0, local1, "')'")
            ElseIf (local5 = ",") Then
                se_createtoken($08, ",", local0, local1, "','")
            ElseIf (local5 = ";") Then
                se_createtoken($09, ";", local0, local1, "';'")
            ElseIf (local5 = "[") Then
                se_createtoken($0A, "[", local0, local1, "'['")
            ElseIf (local5 = "]") Then
                se_createtoken($0B, "]", local0, local1, "']'")
            ElseIf (asc(local5) = $22) Then
                local4 = se_createtoken($03, (Str local6), local0, local1, "string")
                local7 = instr(local2, chr($22), (local1 + $01))
                local4\Field1 = mid(local2, (local1 + $01), ((local7 - local1) - $01))
                local1 = local7
            ElseIf (((local5 >= "0") And (local5 <= "9")) <> 0) Then
                local4 = se_createtoken($01, local5, local0, local1, "integer ")
                Repeat
                    local1 = (local1 + $01)
                    local5 = mid(local2, local1, $01)
                    If (local5 = ".") Then
                        local4\Field0 = $02
                        local4\Field4 = "float "
                    ElseIf (((local5 >= "0") And (local5 <= "9")) = $00) Then
                        local1 = (local1 - $01)
                        Exit
                    EndIf
                    local4\Field1 = (local4\Field1 + local5)
                Until (local1 = local3)
                local4\Field4 = (local4\Field4 + local4\Field1)
            ElseIf (local5 = ".") Then
                local4 = se_createtoken($02, local5, local0, local1, "float ")
                Repeat
                    local1 = (local1 + $01)
                    local5 = mid(local2, local1, $01)
                    If (((local5 >= "0") And (local5 <= "9")) = $00) Then
                        local1 = (local1 - $01)
                        Exit
                    EndIf
                    local4\Field1 = (local4\Field1 + local5)
                Until (local1 = local3)
                local4\Field4 = (local4\Field4 + local4\Field1)
            ElseIf (((((local5 >= "a") And (local5 <= "z")) Or ((local5 >= "A") And (local5 <= "Z"))) Or (local5 = "_")) <> 0) Then
                local4 = se_createtoken($04, local5, local0, local1, "identifier ")
                Repeat
                    local1 = (local1 + $01)
                    local5 = mid(local2, local1, $01)
                    If ((((((local5 >= "0") And (local5 <= "9")) Or ((local5 >= "a") And (local5 <= "z"))) Or ((local5 >= "A") And (local5 <= "Z"))) Or (local5 = "_")) = $00) Then
                        local1 = (local1 - $01)
                        Exit
                    EndIf
                    local4\Field1 = (local4\Field1 + local5)
                Until (local1 = local3)
                local4\Field1 = lower(local4\Field1)
                If (se_checkidentifier(local4) = $00) Then
                    local4\Field4 = (((local4\Field4 + "'") + local4\Field1) + "'")
                EndIf
            Else
                local8 = se_checkoperator(local2, local1)
                If (local8 <> "") Then
                    local4 = se_createtoken($07, local8, local0, local1, ("operator " + local8))
                    local1 = ((len(local8) + local1) - $01)
                Else
                    se_seterror((((("error at line " + (Str local9)) + ": unknown character '") + local5) + "'"), $01)
                    Return $00
                EndIf
            EndIf
        Forever
    Next
    se_createtoken($0E, "", Null, $00, "end of file")
    Return $00
End Function
