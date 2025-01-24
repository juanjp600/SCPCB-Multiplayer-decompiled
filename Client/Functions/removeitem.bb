Function removeitem%(arg0.items)
    Local local0%
    catcherrors("RemoveItem()")
    mp_onremoveitem(arg0, currentsyncitem)
    currentsyncitem = Null
    freeentity(arg0\Field3)
    arg0\Field3 = $00
    freeentity(arg0\Field2)
    arg0\Field2 = $00
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
            Exit
        EndIf
    Next
    If (selecteditem = arg0) Then
        selecteditem = Null
    EndIf
    If (arg0\Field4\Field11 <> $00) Then
        freeimage(arg0\Field4\Field11)
        arg0\Field4\Field11 = $00
    EndIf
    If (arg0\Field4\Field12 <> $00) Then
        freeimage(arg0\Field4\Field12)
        arg0\Field4\Field12 = $00
    EndIf
    Delete arg0
    catcherrors("Uncaught: RemoveItem()")
    Return $00
End Function
