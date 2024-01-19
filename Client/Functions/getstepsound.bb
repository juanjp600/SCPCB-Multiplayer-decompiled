Function getstepsound%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4.materials
    local0 = linepick(entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00), 0.0, -1.0, 0.0, 0.0)
    If (local0 <> $00) Then
        If (getentitytype(local0) <> $01) Then
            Return $00
        EndIf
        local1 = getsurfacebrush(getsurface(local0, countsurfaces(local0)))
        If (local1 <> $00) Then
            local2 = getbrushtexture(local1, $03)
            If (local2 <> $00) Then
                local3 = strippath(texturename(local2))
                If (local3 <> "") Then
                    freetexture(local2)
                EndIf
                For local4 = Each materials
                    If (local4\Field0 = local3) Then
                        If (local4\Field3 > $00) Then
                            freebrush(local1)
                            Return (local4\Field3 - $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local2 = getbrushtexture(local1, $02)
            If (local2 <> $00) Then
                local3 = strippath(texturename(local2))
                If (local3 <> "") Then
                    freetexture(local2)
                EndIf
                For local4 = Each materials
                    If (local4\Field0 = local3) Then
                        If (local4\Field3 > $00) Then
                            freebrush(local1)
                            Return (local4\Field3 - $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local2 = getbrushtexture(local1, $01)
            If (local2 <> $00) Then
                local3 = strippath(texturename(local2))
                If (local3 <> "") Then
                    freetexture(local2)
                EndIf
                freebrush(local1)
                For local4 = Each materials
                    If (local4\Field0 = local3) Then
                        If (local4\Field3 > $00) Then
                            Return (local4\Field3 - $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
        EndIf
    EndIf
    Return $00
    Return $00
End Function
