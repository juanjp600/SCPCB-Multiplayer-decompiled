Function public_getname$(arg0%)
    Select arg0
        Case $47
            Return "OnFillingRoom"
        Case $46
            Return "OnDeactivateWarheads"
        Case $45
            Return "OnItemRefine"
        Case $44
            Return "OnLostConnectionWithCentralServer"
        Case $43
            Return "OnPlayerSCPContained"
        Case $41
            Return "OnScriptLoaded"
        Case $04
            Return "_main"
        Case $01
            Return "user_main"
        Case $02
            Return "OnGenerateWorld"
        Case $03
            Return "OnServerStart"
        Case $05
            Return "OnServerUpdate"
        Case $06
            Return "OnPlayerRequestFiles"
        Case $07
            Return "OnPlayerCuffPlayer"
        Case $08
            Return "OnPlayerActivateWarheads"
        Case $09
            Return "OnPlayerDeactivateWarheads"
        Case $0A
            Return "OnPlayerConsole"
        Case $0B
            Return "OnReceiveRawPacket"
        Case $0C
            Return "OnPlayerMouseHit"
        Case $0D
            Return "OnPlayerShoot"
        Case $0E
            Return "OnPlayerShootRocket"
        Case $0F
            Return "OnPlayerDropGrenade"
        Case $10
            Return "OnPlayerRequestNewRole"
        Case $12
            Return "OnPlayerHitPlayer"
        Case $13
            Return "OnPlayerUseItem"
        Case $14
            Return "OnPlayerActivateFemurBreaker"
        Case $15
            Return "OnPlayerRequestExplosion"
        Case $16
            Return "OnPlayerRconIncorrect"
        Case $17
            Return "OnPlayerRconAuthorized"
        Case $19
            Return "OnPlayerKillPlayer"
        Case $1A
            Return "OnPlayerCreateDecal"
        Case $1B
            Return "OnPlayerSpawnItem"
        Case $1C
            Return "OnPlayerUse1162"
        Case $1D
            Return "OnPlayerTakeItem"
        Case $1E
            Return "OnPlayerDropItem"
        Case $1F
            Return "OnPlayerClickButton"
        Case $20
            Return "OnConnectionResponse"
        Case $21
            Return "OnPlayerSpeaking"
        Case $22
            Return "OnIncomingConnection"
        Case $23
            Return "OnPlayerConnect"
        Case $24
            Return "OnPlayerRotateLever"
        Case $25
            Return "OnPlayerUpdate"
        Case $27
            Return "OnPlayerReleaseSound"
        Case $28
            Return "OnPlayerDisconnect"
        Case $29
            Return "OnServerRestart"
        Case $2A
            Return "OnRoundStarted"
        Case $2C
            Return "OnPlayerEscapeButDead"
        Case $2B
            Return "OnPlayerEscape"
        Case $30
            Return "OnPlayerGetNewRole"
        Case $31
            Return "OnPlayerDownloadFile"
        Case $32
            Return "OnActivateWarheads"
        Case $33
            Return "OnSpawnMTF"
        Case $34
            Return "OnSpawnChaos"
        Case $35
            Return "OnCheatDetected"
        Case $36
            Return "OnCreateItem"
        Case $37
            Return "OnPlayAnnouncement"
        Case $3C
            Return "OnMapUpdate"
        Case $3D
            Return "OnCreateNPC"
        Case $18
            Return "OnPlayerChat"
        Case $3F
            Return "OnPlayerRequestUnlockExits"
        Case $40
            Return "OnPlayerRequestNoTarget"
        Case $2F
            Return "OnWarheadsExplosion"
        Case $42
            Return "OnBadIncomingConnection"
    End Select
    Return ""
End Function