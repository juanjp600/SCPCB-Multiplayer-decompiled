Function createudpstreamext%(arg0%)
    Local local0%
    Local local1%
    If (arg0 <> $00) Then
        Return createudpstream(arg0)
    EndIf
    local0 = rand($C001, $C15C)
    For arg0 = local0 To $C2EC Step $01
        local1 = createudpstream(arg0)
        If (local1 <> $00) Then
            Return local1
        EndIf
    Next
    Return createudpstream($00)
    Return $00
End Function
