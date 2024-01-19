Function se_parsedirective%(arg0$)
    Local local0%
    Local local1%
    Local local2$
    Local local3.se_pptoken
    Local local4%
    Local local5%
    local0 = $01
    local1 = len(arg0)
    Repeat
        local4 = asc(mid(arg0, local0, $01))
        local2 = ""
        If (local4 = $22) Then
            local5 = instr(arg0, chr($22), (local0 + $01))
            If (local5 = $00) Then
                local5 = local1
            EndIf
            local2 = mid(arg0, (local0 + $01), ((local5 - local0) - $01))
            local0 = (local5 + $01)
            local3 = (New se_pptoken)
            local3\Field0 = local2
        ElseIf ((((local4 > $20) And (local4 <> $22)) And (local4 <> $7F)) <> 0) Then
            Repeat
                local2 = (local2 + chr(local4))
                local0 = (local0 + $01)
                If (local0 > local1) Then
                    Exit
                EndIf
                local4 = asc(mid(arg0, local0, $01))
            Until ((((local4 > $20) And (local4 <> $22)) And (local4 <> $7F)) = $00)
            local3 = (New se_pptoken)
            local3\Field0 = local2
        Else
            local0 = (local0 + $01)
        EndIf
        If (local0 > local1) Then
            Exit
        EndIf
    Forever
    Return $00
End Function
