Function resetplayer%()
    Local local0%
    stamina = 60.0
    staminaeffect = 1.0
    staminaeffecttimer = 0.0
    For local0 = $00 To $05 Step $01
        scp1025state[local0] = 0.0
    Next
    bloodloss = 0.0
    superman = $00
    supermantimer = 0.0
    dropspeed = -0.1
    headdropspeed = 0.0
    shake = 0.0
    currspeed = 0.0
    heartbeatvolume = 0.0
    heartbeatrate = 0.0
    heartbeattimer = 0.0
    sanity = 0.0
    restoresanity = $01
    shake = 0.0
    lightflash = 0.0
    blurtimer = 0.0
    falltimer = 0.0
    godmode = $00
    noclip = $00
    blurtimer = 0.0
    killtimer = 0.0
    killanim = $00
    spectate\Field1 = $FFFFFFFF
    injuries = 0.0
    hideentity(head)
    showentity(collider)
    myplayer\Field33 = $00
    eyeirritation = 0.0
    rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
    wearingvest = $00
    wearinggasmask = $00
    wearinghazmat = $00
    wearing1499 = $00
    wearingnightvision = $00
    i_427\Field0 = $00
    i_427\Field1 = 0.0
    myplayer\Field56 = $00
    Return $00
End Function
