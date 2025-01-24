Function updatelightvolume%()
    Local local0.lights
    Local local1#
    If (0.3 < secondarylighton) Then
        If (8.0 > updatelightstimer) Then
            updatelightstimer = (fps\Field7[$00] + updatelightstimer)
        Else
            For local0 = Each lights
                If (local0\Field12 <> Null) Then
                    If (((8.0 > local0\Field12\Field8) Lor (local0\Field12 = playerroom)) <> 0) Then
                        local1 = entitydistancesquared(camera, local0\Field0)
                        If ((hidedistance * hidedistance) > local1) Then
                            templightvolume = max(((((local0\Field10 * local0\Field10) * ((hidedistance - sqr(local1)) / hidedistance)) + templightvolume) / 4.5), 1.0)
                        EndIf
                    EndIf
                EndIf
            Next
            updatelightstimer = 0.0
        EndIf
        lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
    Else
        lightvolume = 1.0
        updatelightstimer = 0.0
    EndIf
    Return $00
End Function
