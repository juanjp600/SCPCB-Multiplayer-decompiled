Function mp_microtimertick%()
    Local local0%
    Local local1%
    local0 = getmicroseconds()
    local1 = (local0 - mp_time\Field2)
    If (local1 < $00) Then
        local1 = (($7FFE795F - mp_time\Field2) + local0)
    EndIf
    mp_time\Field2 = local0
    Return local1
    Return $00
End Function
