# DummyGenerator

Generates dummy punishments for your LibertyBans database.

At the moments. punishments are added with;
- Random victims based on UUIDs,
- Random reasons,
- Random durations.

## Setup

Download the fatjar from the releases section. Run it for the first time, then configure the `sql.yml`
file. Then, follow the syntax mentioned upon boot.

## Examples:

```
ban:20:player - Generates 20 UUID based bans with random reasons, victinms, and durations.
mute:4:address - Generates 4 IP based random mutes with random victims, durations, and reasons.
```
