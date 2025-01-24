Function controlsoundvolume%()
    Local local0.sound
    Local local1%
    For local0 = Each sound
        For local1 = $00 To $0F Step $01
            channelvolume(local0\Field2[local1], (opt\Field20 * opt\Field16))
        Next
    Next
    Return $00
End Function
