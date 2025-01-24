Function rendersecuritycams%()
    Local local0.securitycams
    Local local1%
    Local local2%
    catcherrors("RenderSecurityCams()")
    For local0 = Each securitycams
        local1 = ((6.0 > local0\Field16\Field8) Lor (playerroom = local0\Field16))
        If (local1 <> 0) Then
            If (local0\Field5 <> 0) Then
                If ((((((-6.0 < me\Field10) Lor (-11.0 > me\Field10)) And ((((fog\Field0 * lightvolume) * 1.2) * ((fog\Field0 * lightvolume) * 1.2)) > entitydistancesquared(me\Field60, local0\Field4))) And local0\Field14) And (0.3 < secondarylighton)) <> 0) Then
                    If (local0\Field16\Field7\Field6 <> $05) Then
                        If (entityhidden(local0\Field4) <> 0) Then
                            showentity(local0\Field4)
                        EndIf
                        If (entityhidden(local0\Field7) <> 0) Then
                            showentity(local0\Field7)
                        EndIf
                    EndIf
                    If (local0\Field15 <= local0\Field11) Then
                        local2 = backbuffer()
                        If ((((sc_i\Field4 = Null) Lor (rand($05, $01) = $05)) Lor (local0\Field18 <> $03)) <> 0) Then
                            If (entityhidden(camera) = $00) Then
                                showentity(local0\Field6)
                                hideentity(camera)
                            EndIf
                            cls()
                            setbuffer(local2)
                            renderworld(rendertween)
                            copyrect($00, $00, $200, $200, $00, $00, local2, texturebuffer(sc_i\Field2, $00))
                            If (entityhidden(local0\Field6) = $00) Then
                                showentity(camera)
                                hideentity(local0\Field6)
                            EndIf
                        Else
                            If (entityhidden(camera) = $00) Then
                                hideentity(camera)
                                showentity(sc_i\Field4\Field16\Field2)
                                entityalpha(getchild(sc_i\Field4\Field16\Field2, $02), 1.0)
                                showentity(sc_i\Field4\Field6)
                            EndIf
                            cls()
                            setbuffer(local2)
                            renderworld(rendertween)
                            copyrect($00, $00, $200, $200, $00, $00, local2, texturebuffer(sc_i\Field2, $00))
                            If (entityhidden(sc_i\Field4\Field16\Field2) = $00) Then
                                hideentity(sc_i\Field4\Field6)
                                showentity(camera)
                                hideentity(sc_i\Field4\Field16\Field2)
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (entityhidden(local0\Field4) = $00) Then
                        hideentity(local0\Field4)
                    EndIf
                    If (entityhidden(local0\Field7) = $00) Then
                        hideentity(local0\Field7)
                    EndIf
                EndIf
            EndIf
        EndIf
        If (local0 <> Null) Then
            catcherrors((("Uncaught: RenderSecurityCameras(Room ID: " + (Str local0\Field16\Field7\Field6)) + ")"))
        Else
            catcherrors("Uncaught: RenderSecurityCameras(Screen doesn't exist anymore!)")
        EndIf
    Next
    cls()
    Return $00
End Function
