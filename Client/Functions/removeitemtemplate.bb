Function removeitemtemplate%(arg0.itemtemplates)
    freeentity(arg0\Field5)
    arg0\Field5 = $00
    freeimage(arg0\Field7)
    arg0\Field7 = $00
    If (arg0\Field8 <> $00) Then
        freeimage(arg0\Field8)
        arg0\Field8 = $00
    EndIf
    If (arg0\Field11 <> $00) Then
        freeimage(arg0\Field11)
        arg0\Field11 = $00
    EndIf
    If (arg0\Field12 <> $00) Then
        freeimage(arg0\Field12)
        arg0\Field12 = $00
    EndIf
    If (arg0\Field19 <> $00) Then
        deletesingletextureentryfromcache(arg0\Field19, $00)
        arg0\Field19 = $00
    EndIf
    Delete arg0
    Return $00
End Function
