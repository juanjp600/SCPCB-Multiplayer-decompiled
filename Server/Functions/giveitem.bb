Function giveitem%(arg0$, arg1$, arg2%)
    Local local0.items
    If (server\Field21 <> 0) Then
        For local0 = Each items
            If (local0\Field23 > $00) Then
                If (local0\Field22 = $00) Then
                    If (lower(local0\Field3\Field1) = lower(arg0)) Then
                        If (lower(local0\Field3\Field2) = lower(arg1)) Then
                            removeitem(local0, $01)
                            Exit
                        EndIf
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    local0 = createitem(arg0, arg1, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
    If (local0 <> Null) Then
        entityparent(local0\Field1, $00, $01)
        hideentity(local0\Field1)
        local0\Field15 = $01
        local0\Field22 = arg2
        local0\Field3\Field4 = $01
        local0\Field23 = arg2
    EndIf
    Return $00
End Function
