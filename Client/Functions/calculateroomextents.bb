Function calculateroomextents%(arg0.rooms)
    Local local0#
    Local local1#
    Local local2#
    If (arg0\Field8\Field19 <> 0) Then
        Return $00
    EndIf
    local0 = 0.05
    tformvector(arg0\Field8\Field20, arg0\Field8\Field21, arg0\Field8\Field22, arg0\Field3, $00)
    arg0\Field59 = ((tformedx() + local0) + arg0\Field4)
    arg0\Field60 = (tformedy() + local0)
    arg0\Field61 = ((tformedz() + local0) + arg0\Field6)
    tformvector(arg0\Field8\Field23, arg0\Field8\Field24, arg0\Field8\Field25, arg0\Field3, $00)
    arg0\Field62 = ((tformedx() - local0) + arg0\Field4)
    arg0\Field63 = (tformedy() - local0)
    arg0\Field64 = ((tformedz() - local0) + arg0\Field6)
    If (arg0\Field62 < arg0\Field59) Then
        local1 = arg0\Field62
        arg0\Field62 = arg0\Field59
        arg0\Field59 = local1
    EndIf
    If (arg0\Field64 < arg0\Field61) Then
        local2 = arg0\Field64
        arg0\Field64 = arg0\Field61
        arg0\Field61 = local2
    EndIf
    Return $00
End Function
