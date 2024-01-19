Function giveitem%(arg0$, arg1$, arg2%)
    Local local0%
    Local local1.items
    If (arg2 = $00) Then
        For local0 = $00 To $09 Step $01
            If (inventory(local0) = Null) Then
                inventory(local0) = createitem(arg0, arg1, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
                entitytype(inventory(local0)\Field1, $03, $00)
                entityparent(inventory(local0)\Field1, $00, $01)
                hideentity(inventory(local0)\Field1)
                inventory(local0)\Field15 = $01
                inventory(local0)\Field22 = networkserver\Field28
                inventory(local0)\Field3\Field4 = $01
                Return $00
            EndIf
        Next
    Else
        local1 = createitem(arg0, arg1, 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00, $01)
        entitytype(local1\Field1, $03, $00)
        entityparent(local1\Field1, $00, $01)
        hideentity(local1\Field1)
        local1\Field15 = $01
        local1\Field22 = arg2
        local1\Field3\Field4 = $01
    EndIf
    Return $00
End Function
