Function trim$(arg0$)
    Local local0%
    Local local1%
    Local local2%
    local0 = len(arg0)
    If (local0 = $00) Then
        Return arg0
    EndIf
    local1 = $01
    While (mid(arg0, local1, $01) = " ")
        local1 = (local1 + $01)
        If (local1 > local0) Then
            Return ""
        EndIf
    Wend
    local2 = local0
    While (mid(arg0, local2, $01) = " ")
        local2 = (local2 - $01)
    Wend
    Return mid(arg0, local1, ((local2 + $01) - local1))
    Return ""
End Function
