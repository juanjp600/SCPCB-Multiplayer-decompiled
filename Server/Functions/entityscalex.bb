Function entityscalex#(arg0%, arg1%)
    If (arg1 <> 0) Then
        tformvector(1.0, 0.0, 0.0, arg0, $00)
    Else
        tformvector(1.0, 0.0, 0.0, arg0, getparent(arg0))
    EndIf
    Return sqr((((tformedx() * tformedx()) + (tformedy() * tformedy())) + (tformedz() * tformedz())))
    Return 0.0
End Function
