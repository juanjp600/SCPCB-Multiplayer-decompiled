Function mp_prepareeventnpcs%(arg0.events)
    Local local0%
    If (arg0\Field1 = Null) Then
        Return $00
    EndIf
    For local0 = $00 To $0B Step $01
        If (arg0\Field1\Field15[local0] <> Null) Then
            arg0\Field1\Field15[local0]\Field69 = arg0\Field27
            arg0\Field1\Field15[local0]\Field70 = local0
        EndIf
    Next
    Return $00
End Function
