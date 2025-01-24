Function updatecheckpointmonitors%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    local5 = mon_i\Field0[$01]
    local6 = countsurfaces(local5)
    For local0 = $02 To local6 Step $01
        local1 = getsurface(local5, local0)
        local2 = getsurfacebrush(local1)
        If (local2 <> $00) Then
            local3 = getbrushtexture(local2, $00)
            If (local3 <> $00) Then
                local4 = strippath(texturename(local3))
                If (lower(local4) <> "monitortexture.jpg") Then
                    If (arg0 <> 0) Then
                        If (50.0 > mon_i\Field2[$00]) Then
                            brushtexture(local2, mon_i\Field1[$02], $00, $00)
                        Else
                            brushtexture(local2, mon_i\Field1[$03], $00, $00)
                        EndIf
                    ElseIf (50.0 > mon_i\Field2[$01]) Then
                        brushtexture(local2, mon_i\Field1[$02], $00, $00)
                    Else
                        brushtexture(local2, mon_i\Field1[$01], $00, $00)
                    EndIf
                    paintsurface(local1, local2)
                EndIf
                If (local4 <> "") Then
                    freetexture(local3)
                    local3 = $00
                EndIf
            EndIf
            freebrush(local2)
            local2 = $00
        EndIf
    Next
    local1 = $00
    local5 = $00
    mon_i\Field3[($01 - arg0)] = $01
    Return $00
End Function
