Function mp_assignitem%(arg0.items, arg1.items)
    Local local0%
    Local local1%
    Local local2.items
    If (((mp_getsocket() = $00) Lor (arg0 = Null)) <> 0) Then
        Return $00
    EndIf
    If (arg1 = Null) Then
        local1 = $00
        local2 = mp_items[arg0\Field26]
        If (local2 <> Null) Then
            mp_removeitemfromsecondinv(arg0, local2)
            mp_refreshanimatedbag(local2, (mp_issecondinvempty(local2) = $00))
        EndIf
        arg0\Field26 = $00
    Else
        arg0\Field26 = arg1\Field19
        arg0\Field31 = 70.0
        mp_refreshanimatedbag(arg1, $01)
        If (mp_ishoster() = $00) Then
            mp_client_itemaction_assigning(arg0, arg1)
        EndIf
    EndIf
    Return $00
End Function
