Function peekmemorystringc%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    local0 = arg0
    local1 = $00
    local2 = $00
    local3 = ""
    Repeat
        local2 = peekmemorybyte(local0)
        local0 = (local0 + $01)
        arg1 = (arg1 - $01)
        If (local2 = $00) Then
            arg1 = $00
        Else
            local3 = (local3 + chr(local2))
        EndIf
    Until (arg1 = $00)
    Return (Int local3)
    Return $00
End Function
