Function rowformattext%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%, arg6#)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    If (arg4 < $01) Then
        arg4 = (Int smallest_power_two)
    EndIf
    local0 = $00
    local1 = (Int ((Float aastringheight(arg0)) + arg6))
    While (len(arg0) > $00)
        local3 = instr(arg0, " ", $01)
        If (local3 = $00) Then
            local3 = len(arg0)
        EndIf
        local4 = left(arg0, local3)
        local5 = trim(local4)
        local6 = $00
        If (((aastringwidth((local2 + local4)) > arg3) And (aastringwidth((local2 + local5)) <= arg3)) <> 0) Then
            local4 = local5
            local6 = $01
        EndIf
        If (aastringwidth((local2 + local4)) > arg3) Then
            If (arg5 <> 0) Then
                formattext((Float (((arg3 Sar $01) + arg1) - (aastringwidth(local2) Sar $01))), (Float ((local0 * local1) + arg2)), local2, $00, $00, 1.0, $00)
            Else
                formattext((Float arg1), (Float ((local0 * local1) + arg2)), local2, $00, $00, 1.0, $00)
            EndIf
            local0 = (local0 + $01)
            local2 = ""
        Else
            local2 = (local2 + local4)
            arg0 = right(arg0, (len(arg0) - (len(local4) + local6)))
        EndIf
        If (((local0 + $01) * local1) > arg4) Then
            Exit
        EndIf
    Wend
    If (((local2 <> "") And ((local0 + $01) <= arg4)) <> 0) Then
        If (arg5 <> 0) Then
            formattext((Float (((arg3 Sar $01) + arg1) - (aastringwidth(local2) Sar $01))), (Float ((local0 * local1) + arg2)), local2, $00, $00, 1.0, $00)
        Else
            formattext((Float arg1), (Float ((local0 * local1) + arg2)), local2, $00, $00, 1.0, $00)
        EndIf
    EndIf
    Return $00
End Function
