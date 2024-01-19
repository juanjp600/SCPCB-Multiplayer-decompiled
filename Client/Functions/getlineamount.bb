Function getlineamount%(arg0$, arg1%, arg2%, arg3#)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    If (arg2 < $01) Then
        arg2 = (Int smallest_power_two)
    EndIf
    local0 = $00
    local1 = (Int ((Float aastringheight(arg0)) + arg3))
    While (len(arg0) > $00)
        local3 = instr(arg0, " ", $01)
        If (local3 = $00) Then
            local3 = len(arg0)
        EndIf
        local4 = left(arg0, local3)
        local5 = trim(local4)
        local6 = $00
        If (((aastringwidth((local2 + local4)) > arg1) And (aastringwidth((local2 + local5)) <= arg1)) <> 0) Then
            local4 = local5
            local6 = $01
        EndIf
        If (aastringwidth((local2 + local4)) > arg1) Then
            local0 = (local0 + $01)
            local2 = ""
        Else
            local2 = (local2 + local4)
            arg0 = right(arg0, (len(arg0) - (len(local4) + local6)))
        EndIf
        If (((((local0 + $01) * local1) > arg2) And (arg2 <> $FFFFFFFF)) <> 0) Then
            Exit
        EndIf
    Wend
    Return (local0 + $01)
    Return $00
End Function
