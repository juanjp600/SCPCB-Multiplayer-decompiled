Function readiniline$(arg0.inifile)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    local1 = $01
    local2 = arg0\Field2
    local3 = arg0\Field1
    local4 = ""
    local0 = peekbyte(local3, local2)
    While (((local1 Or ((local0 <> $0D) And (local0 <> $0A))) And (local2 < arg0\Field3)) <> 0)
        local0 = peekbyte(local3, local2)
        If (((local0 <> $0D) And (local0 <> $0A)) <> 0) Then
            local1 = $00
            local4 = (local4 + chr(local0))
        EndIf
        local2 = (local2 + $01)
    Wend
    arg0\Field2 = local2
    Return local4
    Return ""
End Function
