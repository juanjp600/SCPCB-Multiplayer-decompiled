Function stopbreathsound%()
    If (channelplaying(breathchn) <> 0) Then
        stopchannel(breathchn)
        breathchn = $00
    EndIf
    If (channelplaying(breathgasrelaxedchn) <> 0) Then
        stopchannel(breathgasrelaxedchn)
        breathgasrelaxedchn = $00
    EndIf
    Return $00
End Function
