Function peekstring$(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4%
    local0 = arg1
    local1 = banksize(arg0)
    local2 = ""
    local3 = $00
    local4 = $00
    While (((local0 < local1) And (local3 = $00)) <> 0)
        local4 = peekbyte(arg0, local0)
        If (local4 = $00) Then
            local3 = $01
        Else
            local2 = (local2 + chr(local4))
        EndIf
        local0 = (local0 + $01)
    Wend
    Return local2
    Return ""
End Function
