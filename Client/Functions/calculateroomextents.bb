Function calculateroomextents%(arg0.rooms)
    Local local0#
    Local local1#
    If (arg0\Field7\Field9 <> 0) Then
        Return $00
    EndIf
    tformvector(arg0\Field7\Field10, arg0\Field7\Field11, arg0\Field7\Field12, arg0\Field2, $00)
    arg0\Field23 = tformedx()
    arg0\Field24 = tformedy()
    arg0\Field25 = tformedz()
    tformvector(arg0\Field7\Field13, arg0\Field7\Field14, arg0\Field7\Field15, arg0\Field2, $00)
    arg0\Field26 = tformedx()
    arg0\Field27 = tformedy()
    arg0\Field28 = tformedz()
    If (arg0\Field26 < arg0\Field23) Then
        local0 = arg0\Field26
        arg0\Field26 = arg0\Field23
        arg0\Field23 = local0
    EndIf
    If (arg0\Field28 < arg0\Field25) Then
        local1 = arg0\Field28
        arg0\Field28 = arg0\Field25
        arg0\Field25 = local1
    EndIf
    arg0\Field23 = ((arg0\Field23 + 0.05) + arg0\Field3)
    arg0\Field24 = (arg0\Field24 + 0.05)
    arg0\Field25 = ((arg0\Field25 + 0.05) + arg0\Field5)
    arg0\Field26 = ((arg0\Field26 - 0.05) - arg0\Field3)
    arg0\Field27 = (arg0\Field27 - 0.05)
    arg0\Field28 = ((arg0\Field28 - 0.05) - arg0\Field5)
    Return $00
End Function
