Function calculateroomextents%(arg0.rooms)
    Local local0#
    Local local1#
    Local local2#
    If (arg0\Field7\Field18 <> 0) Then
        Return $00
    EndIf
    local0 = 0.05
    tformvector(arg0\Field7\Field19, arg0\Field7\Field20, arg0\Field7\Field21, arg0\Field2, $00)
    arg0\Field57 = ((tformedx() + local0) + arg0\Field3)
    arg0\Field58 = (tformedy() + local0)
    arg0\Field59 = ((tformedz() + local0) + arg0\Field5)
    tformvector(arg0\Field7\Field22, arg0\Field7\Field23, arg0\Field7\Field24, arg0\Field2, $00)
    arg0\Field60 = ((tformedx() - local0) + arg0\Field3)
    arg0\Field61 = (tformedy() - local0)
    arg0\Field62 = ((tformedz() - local0) + arg0\Field5)
    If (arg0\Field60 < arg0\Field57) Then
        local1 = arg0\Field60
        arg0\Field60 = arg0\Field57
        arg0\Field57 = local1
    EndIf
    If (arg0\Field62 < arg0\Field59) Then
        local2 = arg0\Field62
        arg0\Field62 = arg0\Field59
        arg0\Field59 = local2
    EndIf
    debuglog(((((((((((("roomextents: " + (Str arg0\Field57)) + ", ") + (Str arg0\Field58)) + ", ") + (Str arg0\Field59)) + ", ") + (Str arg0\Field60)) + ", ") + (Str arg0\Field61)) + ", ") + (Str arg0\Field62)))
    Return $00
End Function
