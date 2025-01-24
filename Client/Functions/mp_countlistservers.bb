Function mp_countlistservers%(arg0%, arg1%)
    Local local0.mp_listserver
    Local local1%
    local1 = $00
    For local0 = Each mp_listserver
        If (((local0\Field10 = arg0) And (local0\Field16 Lor (arg1 = $00))) <> 0) Then
            local1 = (local1 + $01)
        EndIf
    Next
    Return local1
    Return $00
End Function
