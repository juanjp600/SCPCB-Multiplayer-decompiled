Function mp_fillserverlist%(arg0%)
    Local local0%
    Local local1.mp_listserver
    local0 = $00
    For local1 = Each mp_listserver
        If ((local1\Field16 And (local1\Field10 = arg0)) <> 0) Then
            listservers[local0] = local1
            local0 = (local0 + $01)
        EndIf
    Next
    listservers[local0] = Null
    Return local0
    Return $00
End Function
