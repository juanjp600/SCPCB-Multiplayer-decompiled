Function checkroomdeep%(arg0.rooms, arg1%)
    Local local0#
    If (arg0\Field79 <> 0) Then
        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(arg0\Field2, $00), entityz(arg0\Field2, $00))
        Return (((0.0 <= ((entityy(collider, $00) - entityy(arg0\Field2, $00)) + arg0\Field78)) And ((local0 < arg0\Field80) Or (arg1 = $00))) Or (local0 > (arg0\Field80 * 2.0)))
    Else
        Return (1.0 >= sqrvalue((entityy(collider, $00) - entityy(arg0\Field2, $00))))
    EndIf
    Return $00
End Function
